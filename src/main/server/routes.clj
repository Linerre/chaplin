(ns server.routes
  "Server router."
  (:require
   ;; [reitit.core :as r]
   [reitit.ring :as rring]
   [reitit.ring.middleware.parameters :refer [parameters-middleware]]
   [ring.middleware.anti-forgery :refer [*anti-forgery-token*]]
   [ring.util.http-response :refer
    [method-not-allowed not-acceptable file-response]]
   [server.handlers :as hand]
   [server.ws :as ws]
   ))

;; server/backend routes
(def routes
  [
   ["/" {:name :index,
         :get hand/index-page}]

   ["/search" {:name :search,
               :get {:parameters {:query {:q string?}},
                     :responses {200 {:body {:result string?}}},
                     :handler (fn [{{{:keys [q]} :query} :parameters}]
                                (hand/test-result q)),
                     :middleware [[parameters-middleware]]},
               ;; :responses {:status 200, :body {:page
               ;;                                 }}
               }]

   ;; this blah route is for testing only
   ["/blah" {:name :blah,
             :get (fn [req]
                    {:status 200,
                     :body (file-response "blah.json" {:root "resources/public"})})}]

   ;; for sente ws
   ["/chsk" {:name :chsk,
             :get (fn [req] (ws/ring-ajax-get-or-ws-handshake req)),
             :post (fn [req] (ws/ring-ajax-post req))}]

   ])

(def handler
  (rring/ring-handler
   (rring/router routes)
   (rring/routes
    (rring/create-resource-handler {:path "/",
                                    ;; :root "public",
                                    :not-found-handler hand/page-not-found})
    (rring/create-default-handler
    {:not-found
     (constantly {:status 404, :body (hand/page-not-found {})})
     :method-not-allowed
     (constantly (method-not-allowed "405 - Operations not allowed"))
     :not-acceptable
     (constantly (not-acceptable "406 - Not acceptable"))}))))
