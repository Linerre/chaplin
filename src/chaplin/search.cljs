(ns chaplin.search
  (:require
   [goog.dom :as gdom]
   [reagent.dom :as rdom]
   [reagent.core :as rc]))

(defn search-box
  "Search box fregment"
  []
  [:<>
   [:input.w-half.border-solid.border-2.border-gray-600.p-2
    {:type "text",
     :id "query",
     :name "user_query",
     :placeholder " Title, Author, ISBN, barcode ... "}]])

(defn drop-box
  "Drop-down menu"
  []
  [:select#part-type.p-2.border-2.border-gray-900.bg-purple-950.text-white
   [:option {:value "chapter"} "Chapter"]
   [:option {:value "section"} "Section"]
   [:option {:value "part"} "Part"]
   [:option {:value "lesson"} "Lesson"]
   [:option {:value "pages"} "Pages"]])
(defn search-button
  "Search button fragment"
  []
  [:<>
   [:button#btn.bg-yellow-450.text-black.font-bold.p-2
    {:type "reset"} "Search"]])

(defn form-component
  "Construct the form section"
  []
  [:form.my-4.py-4
   {:action "url" :method "post"
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
