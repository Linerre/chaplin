(ns client.components.header
  "Header section of the index page"
  (:require
   [reagent.core :as r]))

;; Reusable headers, thus id is not applicable
(defn index-header
  "Header for index page."
  []
  [:header.my-4
   [:div.w-full.p-2.flex.items-center.justify-center
    [:span.text-5xl.z-10 "Chap"]
    [:img.h-22.-ml-6.-mr-8.z-0
     {:alt "stick icon",
      :src "img/stick-icon.svg"}]
    [:span.text-5xl.z-10 "in"]]
   [:div.w-full.py-2.my-2.flex.justify-center.gap-x-2
    [:i.fi-page.ml-2]
    [:span.pb-1.border-b-4.border-red-650
     "Search across your scanned chapters"]]])

(defn about-header
  "Header for about page."
  [txt]
  [:header.w-fit.mx-auto.my-2
   [:h2.pr-1.py-1.text-2xl.font-bold txt]
   [:div.h-1.w-full.bg-red-650]])
