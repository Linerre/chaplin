(ns client.components.footer
  "Footer for the index page")

(defn footer-frame
  "Quotation block in the footer."
  [page quo]
  [:footer#main-footer.w-full.pt-6.pb-2.bg-green-750
   {:class (if (= page "Home")
             "fixed bottom-0 left-0"
             "mt-2")}
   [:p.w-triq.mx-auto.italic.text-sm.text-slate-50.text-center.font-bold
    [:span
     quo]]
   [:div.h-fit.pt-4.pb-2.mt-4.flex.flex-col.gap-y-1.text-sm
    [:p.text-center.text-white "Built with "
     [:a.text-white.no-underline.hover:underline
   {:href "https://clojure.org/index",
    :target "_blank"}
   "Clojure(Script)"]]
    [:div.flex.gap-x-2.justify-center.relative.text-center.text-white
     [:div
      [:span "Special thanks to Jade for her hard work"]]
     [:div.absolute.left-8
      [:span "© 2022 Leon Lin"]]
     [:div.absolute.right-8.flex.gap-x-4.justify-center.text-lg
      [:a {:href "https://shanghai.nyu.edu/academics/library",
           :target "_blank"}
       [:i.fi-home]]
      [:a {:href "mailto:zl37@nyu.edu"}
       [:i.fi-mail]]
      [:a {:href "https://github.com/Linerre/chaplin",
           :target "_blank"}
       [:i.fi-social-github]]]]]])
