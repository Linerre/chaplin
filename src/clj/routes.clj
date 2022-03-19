(ns chaplin.routes
  "Various handler functions used by the application.
  Most important includes router and wrappers."
  (:require
   [hiccup.core :as hp]
   [ring.util.http-response :as resp]
   [ring.util.http-predicates :as pred]
   [reitit.ring :as ritr]))

(defn handle-home
  "Handle home page request."
  [req]
  (resp/ok (hp/html [:html
                     [:head]
                     [:body
                      [:h1.banner "I am Chaplin!"]]])))


(defn handler-two [request]
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body "Hello! You are now at Ping!"})

;; routes
(def my-routes
  [["/" {:get handle-home}]])

;; TODO
;; [ ] Figure out why the following code doesn't work as expected
(comment
  "Requst (as a map) always gets passed to a route fn"
  ["/reserves" {:name ::reserves
              :file {:name "res"
                     :type "html"
                     :path "html/res.html"}
              :love "clojure"
              :hate "javascript"
              :get (fn [{{:keys [name]} :file}]
                     (resp/ok {:filename name}))}])
;; expected: => {:filename res}
;; got: => {:filename nil}

;;; ring-handler takes two args
(comment
  ritr/ring-handler (router) (ring-default-handler))

;; TODO
;; [] Add templates for default-handler pages, not-found in particular
(def my-handler
  (ritr/ring-handler
   (ritr/router my-routes)
   (ritr/create-default-handler
    {:not-found
     (constantly (resp/not-found "404 - Page not found"))
     :method-not-allowed
     (constantly (resp/method-not-allowed "405 - Operations not allowed"))
     :not-acceptable
     (constantly (resp/not-acceptable "406 - Not acceptable"))
     })))

(comment
  (ritc/routes my-router)
  (my-handler {:uri "/ping"}))
