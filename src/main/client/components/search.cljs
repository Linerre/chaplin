(ns client.components.search
  "Components for the search box in the middle."
  (:require
   [re-frame.core :refer [dispatch subscribe]]))

(defn search-box
  "Search box component."
  []
  [:label.relative.block
   [:span.sr-only "Search"]
   [:span.absolute.inset-y-0.left-0.pl-4.mr-2.flex.items-center.text-sm.sm:text-base
    [:i.fa-solid.fa-magnifying-glass.text-slate-300]]
   [:input.bg-white.w-full.border.border-slate-300.rounded-full.py-2.pl-9.pr-3.shadow-sm.focus:outline-none.focus:border-yellow-450.focus:ring-yellow-450.focus:ring-1.mx-2.text-xs.sm:text-xs.md:text-base.placeholder:italic
    ;; w-full.leading-spacious.outline-0.border-none.background-none
    {:type "text",
     :id "uquery",
     :name "q",
     :placeholder "Search for title, barcode or ISBN ... ",
     :on-change #(dispatch [:search/user-input (-> % .-target .-value)]),
     :on-key-press (fn [e]
                     (when(= "Enter" (.-key e))
                       (let [user-q (subscribe [:search/current-input])]
                         (dispatch [:search/user-query-dev @user-q]))))}]])


(defn search-frame
  "Search box frame"
  [page]
  [:div#search.w-full.mx-auto
   {:class (if (= "result" page)
             "py-4 md:w-triq"
             "w-full sm:w-near md:w-triq lg:w-half my-4 p-4")}
   [search-box]])
