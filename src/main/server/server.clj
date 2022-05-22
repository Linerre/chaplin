(ns server.server
  (:require
   [org.httpkit.server :refer [run-server]]
   [ring.middleware.cookies]
   [ring.middleware.reload :refer [wrap-reload]]
   [ring.middleware.keyword-params :refer [wrap-keyword-params]]
   [ring.middleware.params  :refer [wrap-params]]
   [ring.middleware.cors :refer [wrap-cors]]
   [ring.middleware.anti-forgery :refer [wrap-anti-forgery]]
   [ring.middleware.session :refer [wrap-session]]
   [server.routes :as router]
   ))

(def allowed-origins [#"https://example-a.com" #"https://example-b.com"])

(def allowed-methods [:get :post :put :delete])

(def allowed-headers #{:accept :content-type})



(def app
  ;; wrap for dev only
  (-> router/handler
      (wrap-cors :access-control-allow-origin allowed-origins
                 :access-control-allow-methods allowed-methods
                 :access-control-allow-headers allowed-headers)
      (wrap-keyword-params)
      (wrap-params)
      ;; (wrap-anti-forgery)
      (wrap-session)
      (wrap-reload)
))

;; Server will not be re-defined by (def x)
;; atom makes server state independent of others
;; Use @server to access it
;; Use reset! to change it value
;; NOTE when resetting it, @ symbol is not needed!
(defonce server (atom nil))

(defn start-server [& args]
  (reset! server (run-server #'app {:port 9321}))
  (println "Server started on port 9321 successfully!"))

(defn stop-server [& args]
  (when-not (nil? @server)
    (@server :timeout 100)
    (reset! server nil)
    (println "Server stopped!")))

;; restart = stop + start
(defn restart-server []
  (stop-server)
  (println "Stopped the server and restarting ...")
  (start-server))

(comment (restart-server))
