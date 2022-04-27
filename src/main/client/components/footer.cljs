(ns client.components.footer
  "Footer for the index page")

(defn footer-frame
  "Quotation block in the footer."
  [quo]
  [:footer#quo.h-fit.w-full.pt-6.pb-2.fixed.bottom-0.left-0.bg-green-750
   [:p.text-center.italic.text-slate-100
    [:span.text-sm.text-white
     quo]]
   [:div.h-fit.pt-4.pb-2.mt-4.flex.flex-col.gap-y-1.text-sm
    [:p.text-center.text-white "Built with
" [:a.text-white.no-underline.hover:underline
   {:href "https://clojure.org/index",
    :target "_blank"}
   "Clojure(Script)"]]
    [:p.text-center.text-white "Thanks Jade for her hard work"]]])
