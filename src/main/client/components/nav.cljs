(ns chaplin.client.components.nav
  (:require
   [reagent.core]))

(def nav-urls "Links for navigation bar."
  {:copyright {:url "https://guides.nyu.edu/copyright",
               :txt "Copyright"},
   :policy    {:url "https://shanghai.nyu.edu/academics/library/policy",
               :txt "Policy"},
   :scanning  {:url "https://library.nyu.edu/nyu-returns/collections-access/#scanning",
               :txt "Scanning"},
   :reserve   {:url "https://shanghai.nyu.edu/academics/library/services/course-reserves",
               :txt "Linking Service"},
   :contact   {:url "mailto:zl37@nyu.edu",
               :txt "Contact"},
   :about     {:url "https://github.com/Linerre/chaplin",
               :txt "About"}})

(defn main-icon
  "The site icon, clickable and linking to the index page."
  []
  [:div.flex.my-2.px-2.text-left
   [:a {:href "http://localhost:9321"}
    [:img.w-12 {:alt "Site Icon - Chaplin"
                :src "img/chaplin-200x200.png"}]]])

(defn nav-items
  "Top navigation bar."
  [items-map]
  [:ul#nav-items.flex.gap-x-6.justify-center
   (for [item (seq (keys items-map))]
     ^{:key item} [:li.mx-1
                   [:a.underline.hover:text-blue-350
                    {:href (get-in items-map [item :url]),
                     :target "_blank"}
                    (get-in items-map [item :txt])]])])

(defn nav-bar-frame
  "Frame holds the top navigation bar."
  []
  [:div.my-2.gap-2.flex.flex-col.sm:flex-row.flex-wrap.items-center.justify-center
   [main-icon]
   [nav-items nav-urls]])
