(ns client.components.nav
  "The top navigation bar. It holds two special routes:
  1. Home page (the Chaplin icon)
  2. About page"
  (:require
   [re-frame.core :refer [dispatch]]
   [reitit.frontend.easy :as rfe]))

;; This is an example demenstrating that a component doesn't
;; have to follow the pattern of "children elements + frame".
;; Instead, a component should be a reusable block, even the
;; component fn is a bit lengthy.


(defn top-nav
  "The top navigation bar. It should appear on both index and about page."
  []
  [:nav.my-2.gap-4.flex.flex-col.flex-wrap.items-center.justify-center.tb:flex-row
   [:div.flex.my-2.px-2
    ;; keyword has no special meaning in this ns
    ;; but get their special meaning in client.router ns
    [:a {:href (rfe/href :home)}
     [:img.w-12 {:alt "Site Icon - Chaplin",
                 :src "/img/chaplin-200x200.png"}]]]
   [:ul.px-2.flex.flex-wrap.gap-x-10.justify-center.text-sm.sm:text-base
    [:li [:a {:href "https://guides.nyu.edu/copyright",
              :target "_blank",
              :class "underline hover:text-blue-350"} "Copyright"]]
    [:li [:a {:href "https://shanghai.nyu.edu/academics/library/policy",
              :target "_blank",
              :class "underline hover:text-blue-350"} "Policies"]]
    [:li [:a {:href "https://library.nyu.edu/nyu-returns/collections-access/#scanning",
              :target "_blank",
              :class "underline hover:text-blue-350"} "Scanning"]]
    [:li [:a {:href "https://shanghai.nyu.edu/academics/library/services/course-reserves",
              :target "_blank",
              :class "underline hover:text-blue-350"} "Linking Services"]]
    [:li [:a {:href (rfe/href :about),
              :class "underline hover:text-blue-350"}
          "About"]]]])
