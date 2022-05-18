(ns client.components.search
  "Components for the search box in the middle."
  (:require
   [re-frame.core :refer [dispatch subscribe]]))

;; If a component is for triggering an event,
;; dispatch the event here
(defn select-dropdwon
  "Dropdwon menu for selecting parts."
  []
  [:select#search-type.order-2.tb:order-1.p-1.bg-purple-950.text-white.text-center.rounded.hover:bg-purple-900.hover:cursor-pointer
     {:id "ptype",
      :name "ptype",
      :on-change #(dispatch [:search/part (-> % .-target .-value)])}
     [:option {:name "chapter", :value "chapter"} "Chapter"]
     [:option {:name "section", :value "section"} "Section"]
     [:option {:name "part",    :value "part"} "Part"]
     [:option {:name "lesson",  :value "lesson"} "Lesson"]
     [:option {:name "pages",   :value "pages"} "Pages"]])

(defn search-btn
  "The search button for submitting user's query."
  [state]
  [:button#search-btn.flex-initial.rounded.bg-yellow-450.text-black.font-bold.p-2.hover:brightness-110
   {:on-click (fn [e]
                ;; (.preventDefault e)
                (dispatch [:search/click]))
    :type "submit",
    :value "Search"}
   "Search"])

(defn search-box
  "Search box for user input, accepting title, ISBN, author and barcode."
  []
  [:label.relative.block
   [:span.sr-only "Search"]
   [:span.absolute.inset-y-0.left-0.pl-4.flex.items-center
    [:i.fi-magnifying-glass.text-slate-300]]
   [:input.bg-white.w-full.border.border-slate-300.rounded-full.py-2.pl-9.pr-3.shadow-sm.focus:outline-none.focus:border-yellow-450.focus:ring-yellow-450.focus:ring-1.mx-auto
    ;; w-full.leading-spacious.outline-0.border-none.background-none
    {:type "text",
     :id "uquery",
     :name "q",
     :placeholder " Title, Author, ISBN, barcode ... ",
     :on-change #(dispatch [:search/input (-> % .-target .-value)]),
     :on-key-press (fn [e]
                  (if (= "Enter" (.-key e))
                    (.alert js/window "You pressed enter")))}]]


  )
;; in {:attr "val"}, "val" can be :val
;; but :val will be converted to "val" for DOM anyway
(defn search-frame
  "Search box frame"
  []
  [:form#search.w-half.my-4.p-4.mx-auto
   {:action "/result",
    :method "GET"}
   [search-box]]
  )
