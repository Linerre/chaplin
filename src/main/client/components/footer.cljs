(ns client.components.footer
  "Footer for index, about, and result pages."
  (:require
   [reitit.frontend.easy :as rfe]))

(defn footer-frame
  "Footer that holds quotation, copyright and misc info."
  [page]
  [:footer.h-fit.w-full.py-2
   {:class (case page
             "home"  "bg-green-750 text-white absolute bottom-0"
             "about" "bg-purple-950 text-white"
             "bg-slate-25 text-slate-500 absolute bottom-0")}
   [:div.flex.flex-col.justify-center.items-center.pb-1.tb:items-end.tb:flex-row
    [:div.order-2.sm:order-1.flex-1.text-center.sm:text-left.sm:ml-4.text-xs.sm:text-sm
     [:span "Copyright © 2022 Leon Lin"]]

    ;; thanks
    [:div.order-1.sm:order-2.flex-1.flex.flex-col.justify-center
     [:div.mx-auto.text-center.text-xs.sm:text-sm
      [:span "Special thanks to Jade"]]
     [:div.text-center.text-xs.sm:text-sm
      "Built with "
      [:a.no-underline.hover:underline.text-xs.sm:text-sm
       {:href "https://clojure.org/index",
        :target "_blank"}
       "Clojure(Script)"]]]

    ;; icons
    [:p.order-3.flex-1.flex.gap-x-4.justify-end.mr-4.text-lg.sm:text-xl
     ;; NYU Shanghai library
     [:a {:href "https://shanghai.nyu.edu/academics/library",
          :target "_blank"}
      [:i.fa-solid.fa-house]]
     ;; Contact
     [:a {:href "mailto:zl37@nyu.edu"}
      [:i.fa-solid.fa-envelope]]
     ;; Github
     [:a {:href "https://github.com/Linerre/chaplin",
          :target "_blank"}
      [:i.fa-brands.fa-github]]
     ;; About page
     [:a {:href (rfe/href :about)}
      [:i.fa-solid.fa-circle-info]]]]])
