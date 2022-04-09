(ns chaplin.search
  (:require
   [ajax.core :refer [POST GET]]
   [goog.dom :as gdom]
   [reagent.dom :as rdom]
   [chaplin.router :as router]))

;; TODO:
;; [X]. Combine the components into one form
;; [X]. Send data to the server
;; [X]. Running server to return a requested page

(defn send-message
  "Send user input as a map to the server."
  [fields]
  (GET "/result"
       {:params @fields,
        :handler #(.log js/console (str "response:" %)),
        :err-handler #(.log js/console (str "error:" %))}))



;; in {:attr "val"}, "val" can be :val
;; but :val will be converted to "val" for DOM anyway

(defn render-simple []
  (rdom/render
    [router/search-box]
    ; (. js/document (getElementById "app"))
    (js/document.getElementById "app")))


(defn -main []
  (render-simple))

(defn after-load! []
  (render-simple)
  )
