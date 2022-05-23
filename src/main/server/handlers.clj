(ns server.handlers
  (:require
   [clojure.edn :as edn]
   [hiccup.core :as html]
   [hiccup.page :as page]
   [ring.util.http-response :refer [resource-response]]
   [server.pages.result :refer [query-result]]
   ))

;; resource root defaults to index page
(defn index-page
  [req]
  {:status 200,
   :body (html/html
          [:html
           [:head
            [:title "Chaplin"]
            [:meta
             {:name    "viewport",
              :content "width=device-width, initial-scale=1.0"}]
            [:meta {:charset "UTF-8"}]
            (page/include-css "css/foundation-icons.css")
            (page/include-css "css/app.css")]
           [:body
            [:div#app-mnt-pnt
             (page/include-js "js/app.js")]]])}
  ;; (assoc (resource-response "index.html" {:root "public"})
  ;;        :headers {"Content-Type",
  ;;                  "text/html; charset=UTF-8"})
  )



(def books
  {:google "Google is great",
   :baidu  "Baidu sucks",
   :gogod  "Privacy",
   :bing   "Emmmmmm"
   })

;; suppose the url is http://<domain>/search?q=google
(defn test-result [req]
  {:status 200,
   ;; (:query-string req) => q=google
   ;; (:query-params req) => ["q" "google"]
   ;; (:params req)       => [:q "google"]
   :headers {"Content-Type" "text/html"}
   :body (get (:query-params req) "q")}
)

;; (html/html
;;           [:html
;;            [:head
;;             [:title "Search"]
;;             (page/include-css "css/foundation-icons.css")
;;             (page/include-css "css/app.css")
;;             ]
;;            [:body
;;             [:div#app-mnt-pnt
;;              (page/include-js "js/app.js")
;;              [:div
;;               [:span (str "The query is " q)]]
;;              ]
;;             ]])
;; (let [params (:query-params req)]
;;            (assoc books :query params))
;; (for [[k v] params]
;;
;;                    )

;; TODO: make this fn return a well-crated html file
(defn page-not-found
  "Handler for code 404."
  [req]
  (html/html
   [:html
    [:head
     (page/include-css "css/app.css")]
    [:body
     [:h1.bg-purple-950.text-white "Page Not Found!"]]]))
