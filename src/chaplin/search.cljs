(ns chaplin.search
  (:require
   [ajax.core :refer [POST GET]]
   [goog.dom :as gdom]
   [reagent.dom :as rdom]
   [reagent.core :as rc]))

;; TODO:
;; [X]. Combine the components into one form
;; []. Send data to the server
;; []. Running server to return a requested page

(defn send-message
  "Send user input as a map to the server."
  [fields]
  (GET "/result"
       {:params @fields,
        :handler #(.log js/console (str "response:" %)),
        :err-handler #(.log js/console (str "error:" %))}))

(defn search-box
  "Search box fregment"
  []
  (let [fields (rc/atom {})]
    [:form.my-4.py-4
     {:action "http://localhost:9322/result", :method "POST",
      :class "w-full flex flex-row gap-x-4 justify-center my-4"}
     [:select#part-type.p-2.border-2.border-gray-900.bg-purple-950.text-white
      {:id "ptype",
       :name "ptype"
       :on-change #(swap! fields
                          assoc :name (-> % .-target .-value))}
      [:option {:name "chapter", :value "chapter"} "Chapter"]
      [:option {:name "section", :value "section"} "Section"]
      [:option {:name "part",    :value "part"} "Part"]
      [:option {:name "lesson",  :value "lesson"} "Lesson"]
      [:option {:name "pages",   :value "pages"} "Pages"]]
     [:label {:for "uquery"}]
     [:input.w-half.border-solid.border-2.border-gray-600.p-2
      {:type "text",
       :id "uquery",
       :name "uquery",
       :placeholder " Title, Author, ISBN, barcode ... "
       :on-change #(swap! fields
                          assoc :name (-> % .-target .-value))}]
     [:button#btn.bg-yellow-450.text-black.font-bold.p-2
      {:type "submit",
       :on-click #(send-message fields),
       :value "Search"}
      "Search"]]))

;; in {:attr "val"}, "val" can be :val
;; but :val will be converted to "val" for DOM anyway



(defn simple-component []
  [search-box])

(defn render-simple []
  (rdom/render
    [simple-component]
    ; (. js/document (getElementById "app"))
    (js/document.getElementById "app")))

(defn -main []
  (render-simple))

(defn after-load! []
  (render-simple)
  )
