(ns client.pages.result
  (:require
   [client.components.icon :as icon]
   [client.components.search :refer [search-frame]]
   [re-frame.core :as re-frame]))

(defn result-page [match]
  ;; q(uery) comes from route parameters
  (let [{:keys [query]} (:parameters match) ]
    [:div.w-screen.h-screen
     ;; top bar: icon (back to home) + search bar
     [:div.w-full.flex.border-b-2
      ;; icon
      [icon/chaplin-icon]
      ;; search bar
      [:div.flex-1.flex.flex-col.justify-center.mx-auto
       [search-frame]
       ;; checkbox
       [:div.flex.justify-center.items-center.gap-x-4.p-2.mx-auto
        [:span.checkbox-wrapper
         [:input.mr-1 {:type "checkbox", :id "wholeword",
                  :name "wholeword", :value "Wholeword"}]
         [:label {:for "wholeword"} "Wholeword"]]
        [:span.checkbox-wrapper
         [:input.mr-1 {:type "checkbox", :id "wholeword",
                  :name "wholeword", :value "Wholeword"}]
         [:label {:for "wholeword"} "Wholeword"]]

        ;;
        ]]

      ]

     ;; body = sidebar + result list
     [:div.w-full.flex
      ;; sidebar
      [:div.flex-initial.grow-0.w-quar.max-w-thir.p-2.border-r-2
       [:p "Public data suggests that several anonymous crypto investors profited from inside knowledge of when tokens would be listed on exchanges."]]

      ;; result list
      [:ul.px-2
       (for [x (take 10 (range 50))]
         ^{:key x}
         [:li x])]

      [:p @(re-frame/subscribe [:search/query-result])]
      ]])
  )
