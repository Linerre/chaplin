(ns client.pages.result
  (:require
   [client.components.icon :as icon]
   [client.components.search :refer [search-frame]]
   [client.components.result :as result]
   [client.components.footer :refer [footer-frame]]
   [re-frame.core :as re-frame]))

(defn result-page []
  (let [u-query (re-frame/subscribe [:search/user-query])]
    [:div.w-screen.h-screen.bg-slate-25.flex.flex-col.relative
     [:div.border-b-2.flex.px-2.mt-2.sm:px-16.bg-white
      ;; icon
      [icon/chaplin-icon]
      ;; search bar
      [:div.flex-1.flex.flex-col.justify-center.mx-auto
       [search-frame "result"]
       ;; checkboxes
       [:div.w-meet.flex.justify-around.items-center.gap-x-3.mx-auto.pb-3
        ;; from most common to lest
        (for [f [:chapter :section :pages :lesson :part]]
          ^{:key f} [result/result-filter f])]]]

     ;; body = sidebar + result list
     [:div.flex-1.w-near.mx-auto
      [result/result-item :chapter]
      [result/result-item :section]
      [result/result-item :pages]
      [result/result-item :lesson]
      [result/result-item :part]]

     ;; footer
     [footer-frame "result"]]))
