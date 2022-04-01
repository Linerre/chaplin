(ns chaplin.search
  (:require
   [ajax.core :refer [POST GET]]
   [goog.dom :as gdom]
   [reagent.dom :as rdom]
   [reagent.core :as rc]))

(defn search-box
  "Search box fregment"
  []
  [:<>
   [:label {:for "uquery"}]
   [:input.w-half.border-solid.border-2.border-gray-600.p-2
    {:type "text",
     :id "uquery",
     :name "uquery",
     :placeholder " Title, Author, ISBN, barcode ... "}]])

(defn drop-box
  "Drop-down menu"
  []
  [:select#part-type.p-2.border-2.border-gray-900.bg-purple-950.text-white
   {:id "ptype",
    :name "ptype"}
   [:option {:name "chapter", :value "chapter"} "Chapter"]
   [:option {:name "section", :value "section"} "Section"]
   [:option {:name "part",    :value "part"} "Part"]
   [:option {:name "lesson",  :value "lesson"} "Lesson"]
   [:option {:name "pages",   :value "pages"} "Pages"]])

;; in {:attr "val"}, "val" can be :val
;; but :val will be converted to "val" for DOM anyway
(defn search-button
  "Search button fragment"
  []
  [:<>
   [:button#btn.bg-yellow-450.text-black.font-bold.p-2
    {:type "submit"} "Search"]])

(defn form-component
  "Construct the form section"
  []
  [:form.my-4.py-4
   {:action "/result", :method "GET",
    :class "w-full flex flex-row gap-x-4 justify-center my-4"}
   [drop-box]
   [search-box]
   [search-button]])

(defn simple-component []
  [:div
   [form-component]
   ])

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
