(ns client.components.search
  "Components for the search box in the middle."
  (:require
   [re-frame.core :refer [dispatch subscribe]]))

(defn search-box
  "Search box for user input, accepting title, ISBN, author and barcode."
  []
  [:label.relative.block
   [:span.sr-only "Search"]
   [:span.absolute.inset-y-0.left-0.pl-4.flex.items-center.text-sm.sm:text-base
    [:i.fi-magnifying-glass.text-slate-300]]
   [:input.bg-white.w-full.border.border-slate-300.rounded-full.py-2.pl-9.pr-3.shadow-sm.focus:outline-none.focus:border-yellow-450.focus:ring-yellow-450.focus:ring-1.mx-auto.text-xs.sm:text-xs.md:text-base.placeholder:italic
    ;; w-full.leading-spacious.outline-0.border-none.background-none
    {:type "text",
     :id "uquery",
     :name "q",
     :placeholder "Search for title, barcode or ISBN ... ",
     :on-change #(dispatch [:search/user-input (-> % .-target .-value)]),
     :on-key-press (fn [e]
                     (let [user-q (subscribe [:search/current-input])]

                       (if (= "Enter" (.-key e))
                         (do
                           ;; (.preventDefault e)
                           (dispatch [:search/user-query @user-q]))
                         ))

                     )}]
   ])

;; in {:attr "val"}, "val" can be :val
;; but :val will be converted to "val" for DOM anyway

(defn search-frame
  "Search box frame"
  []
  [:div#search.w-full.sm:w-near.md:w-triq.lg:w-half.my-4.p-4.mx-auto
   [search-box]]
  )
