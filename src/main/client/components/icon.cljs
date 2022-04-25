(ns client.components.icon
  (:require
   [reagent.core :as rc]
   [reagent.dom :as rdom]))

(defn chaplin-icon []
  [:div.flex.my-2.px-2
   [:a {:href "http://localhost:9321/"}
    [:img.w-12
     {:alt "Site Icon - Chaplin",
      :src "img/chaplin-200x200.png"}]]])

(defn magnifying-glass []
  [:i.fi-magnifying-glass.ml-2])

(defn render-test []
  (rdom/render
   [chaplin-icon]
   (. js/document (getElementById "test"))))
