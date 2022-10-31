(ns client.components.header
  "Header section of the index page"
  (:require
   [reagent.core :as r]))

(defn index-description
  "Header for index page."
  []

  [:div.mt-10
   [:div.p-2.flex.items-center.justify-center
    [:span.text-3xl.sm:text-5xl.z-10 "Chap"]
    [:img.h-12.-ml-3.-mr-4.sm:h-22.sm:-ml-6.sm:-mr-8.z-0
     {:alt "stick icon",
      :src "img/stick-icon.svg"}]
    [:span.text-3xl.sm:text-5xl.z-10 "in"]]
   [:div.w-full.py-2.my-1.sm:my-2.flex.justify-center.items-center.gap-x-2.mx-auto

    [:span.p-1.border-b-4.border-red-650.text-purple-950.text-sm.sm:text-base
     "Search across your scanned chapters"
     [:i.fi-page.ml-2]]]
   ])

(defn about-header
  "Header for about page."
  [txt]
  [:header.w-fit.mx-auto.my-2
   [:h2.py-1.px-2.text-lg.sm:text-2xl.font-bold.text-purple-950 txt]
   [:div.h-1.w-full.bg-red-650]])
