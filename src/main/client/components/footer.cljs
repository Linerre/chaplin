(ns client.components.footer
  "Footer for the index page")

(defn footer-frame
  "Footer that holds quotation, copyright and misc info."
  [page]
  [:footer.h-fit.w-full.py-2.bg-green-750
   {:class (if (= "home" page) "absolute bottom-0" "")}
   ;; [:div.w-full.md:w-near.mb-4.mx-auto.py-4
   ;;  [:p.w-full.mx-auto.text-center.text-sm
   ;;   [:span.italic.text-slate-50 quo]]]
   [:div.flex.flex-col.justify-center.items-center.pb-1.tb:items-end.tb:flex-row
    ;; copyright
    [:p.order-2.sm:order-1.flex-1.text-center.sm:text-left.sm:ml-4.text-white.text-xs.sm:text-sm
     [:span "Copyright © 2022 Leon Lin"]]

    ;; thanks
    [:div.order-1.sm:order-2.flex-1.flex.flex-col.justify-center
     [:p.mx-auto.text-center.text-white.text-xs.sm:text-sm
      [:span "Special thanks to Jade"]]
     [:p.text-center.text-white.text-xs.sm:text-sm
      "Built with "
      [:a.text-white.no-underline.hover:underline.text-xs.sm:text-sm
       {:href "https://clojure.org/index",
        :target "_blank"}
       "Clojure(Script)"]]]

    ;; icons
    [:p.order-3.flex-1.flex.gap-x-4.justify-end.mr-4.text-white.text-lg
     [:a {:href "https://shanghai.nyu.edu/academics/library",
          :target "_blank"}
      [:i.fi-home]]
     [:a {:href "mailto:zl37@nyu.edu"}
      [:i.fi-mail]]
     [:a {:href "https://github.com/Linerre/chaplin",
          :target "_blank"}
      [:i.fi-social-github]]]]])
