(ns client.components.icon
  (:require
   [reitit.frontend.easy :as rfe]))

(defn chaplin-icon []
  [:div.flex-initial.flex.my-2.px-2
   [:a.w-full.h-auto {:href (rfe/href :home)}
    [:img.w-12.h-auto
     {:alt "Site Icon - Chaplin",
      :src "img/chaplin-200x200.png"}]]])

(defn magnifying-glass []
  [:i.fi-magnifying-glass.ml-2])
