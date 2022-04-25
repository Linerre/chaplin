(ns chaplin.client.components.header
  "Header section of the index page"
  (:require
   [reagent.core :as r]))

(defn site-header
  "The header area showing the site's name."
  []
  [:<>
   [:div.w-full.my-4.p-2.flex.items-center.justify-center
    [:span.text-5xl.z-10 "Chap"]
    [:img.h-22.-ml-6.-mr-8.z-0
     {:alt "stick icon",
      :src "img/stick-icon.svg"}]
    [:span.text-5xl.z-10 "in"]]
   [:div.w-full.py-2.my-2.flex.justify-center.gap-x-2
    [:i.fi-page.ml-2]
    [:span.pb-1.border-b-4.border-red-650
     "Find scanned PDF chapters, sections, or pages"]]])
