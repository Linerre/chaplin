(ns client.pages.result
  (:require
   [client.components.icon :as icon]
   [client.components.search :refer [search-frame]]
   [client.components.result :as result]
   [re-frame.core :as re-frame]))

(defn result-page []
  ;; q(uery) comes from route parameters

  (let [u-query (re-frame/subscribe [:search/user-query])]
    [:div.w-screen.h-screen
     ;; top bar: icon (back to home) + search bar
     [:div.w-full.border-b-2.flex.px-2.mt-2.sm:px-16
      ;; icon
      [icon/chaplin-icon]
      ;; search bar
      [:div.flex-1.flex.flex-col.justify-center.mx-auto
       [search-frame "result"]
       ;; checkboxes
       [:div.w-meet.flex.justify-around.items-center.gap-x-3.mx-auto.pb-3
        ;; from most common to lest
        (for [pt [:chapter :section :pages :lesson :part]]
          ^{:key pt} [result/result-filter pt])
]]
      ]

     ;; body = sidebar + result list
     [:div.w-full                       ; body outer frame
      [:div.w-near.mx-auto.flex         ; body inner frame
       ;; sidebar
       [:div.flex-initial.grow-0.w-quar.max-w-thir.p-2.border-r-2
        [:p "Public data suggests that several anonymous crypto investors profited from inside knowledge of when tokens would be listed on exchanges."]]
       ;; result list

       ;; pass keywords!!!!!
       [:div.w-full
        [result/result-item :chapter]
        [result/result-item :section]
        [result/result-item :pages]
        [result/result-item :lesson]
        [result/result-item :part]
        ]
       ;; [:p (str "User is looking for " @u-query)]
       ]


      ]])
  )
