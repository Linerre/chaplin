(ns client.pages.result
  (:require
   [client.components.icon :as icon]
   [client.components.search :refer [search-frame]]
   [client.components.result :refer [result-item]]
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
       ;; checkbox
       [:div.w-half.flex.justify-around.items-center.gap-x-2.mx-auto.pb-3
        ;; chapter
        [:div.checkbox-wrapper.flex.items-center.gap-x-1
         [:input.mr-1.scale-125.cursor-pointer
          {:type "checkbox",
           :id "chapter",
           :name "chapter"}
          ]
         [:label {:for "chapter"} "Chapter"]]
        ;; section
        [:div.checkbox-wrapper.flex.items-center.gap-x-1
         [:input.mr-1.scale-125.cursor-pointer
          {:type "checkbox",
           :id "section",
           :name "section"}]
         [:label {:for "section"} "Section"]]
        ;; Part
        [:div.checkbox-wrapper.flex.items-center.gap-x-1
         [:input.mr-1.scale-125.cursor-pointer
          {:type "checkbox",
           :id "part",
           :name "part"}
          ]
         [:label {:for "part"} "Part"]]
        ;; Lesson
        [:div.checkbox-wrapper.flex.items-center.gap-x-1
         [:input.mr-1.scale-125.cursor-pointer
          {:type "checkbox",
           :id "lesson",
           :name "lesson"}
          ]
         [:label {:for "lesson"} "Lesson"]]

        ]]

      ]

     ;; body = sidebar + result list
     [:div.w-full                       ; body outer frame
      [:div.w-near.mx-auto.flex         ; body inner frame
       ;; sidebar
       [:div.flex-initial.grow-0.w-quar.max-w-thir.p-2.border-r-2
        [:p "Public data suggests that several anonymous crypto investors profited from inside knowledge of when tokens would be listed on exchanges."]]
       ;; result list

       [:div.w-full
        [result-item "Chapter"]
        [result-item "Chapter"]
        [result-item "Page"]
        [result-item "Section"]
        [result-item "Lesson"]
        [result-item "Part"]
        [result-item "Part"]
        ]
       ;; [:p (str "User is looking for " @u-query)]
       ]


      ]])
  )
