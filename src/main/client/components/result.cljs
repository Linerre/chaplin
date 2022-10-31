(ns client.components.result
  (:require
   [clojure.string :as cstr]
   [re-frame.core :refer [dispatch subscribe]]))

(defn result-filter
  "Checkbox for filtering search results."
  [part-type]
  [:div.flex.items-center.gap-x-2
   [:input.w-4.h-4.cursor-pointer
    {:type "checkbox",
     :id part-type,
     :name part-type,
     :value part-type,
     :on-change (fn []
                  (dispatch [:result/checked-type part-type])
                  (dispatch [:result/enabled-filter]))
     :checked @(subscribe [:result/checked? part-type])}]
   [:label.capitalize {:for part-type} (cstr/replace (str part-type) #":" "")]])

(defn result-item
  [part-type]
  (let [filter  @(subscribe [:result/filter-on?])
        checked @(subscribe [:result/checked? part-type])]
    [:div.w-near.my-2.mx-auto.flex.items-center.gap-x-2.border-1.rounded.hover:border-sky-500
     {:class (if filter
               (if checked "" "hidden")
               "")}
     ;; cover
     [:div.shrink-0.grow-0.flex
      [:img.w-44.h-auto.rounded-l.border-0
       {:src "img/covers/31124068856146_Database System Concepts.jpg",
        :alt "Book Cover Image"}]]
     ;; Citation
     [:div.flex-auto.shrink-1.mx-1.p-1.flex.flex-col.gap-y-2
      [:div                                 ; title
       [:span.flex.gap-x-4.items-start
        [:img.w-5.h-5 {:src "img/book.png" :alt "book icon"}]
        [:span.leading-5                  ; consider detect title length
         "Database Systems Concepts"]]]   ; if > 8 wds, then add leading-5
      [:div                                 ; ISBN
       [:span.flex.gap-x-4.items-center
        [:img.w-5.h-5 {:src "img/isbn.png" :alt "isbn icon"}]
        [:span "9781234560001"]]]
      [:div                                 ; barcode
       [:span.flex.gap-x-4.items-center
        [:img.w-5.h-5 {:src "img/barcode.png" :alt "barcode icon"}]
        [:span "31124056788904"]]]
      [:div                                 ; part type
       [:span.flex.gap-x-4.items-center
        [:img.w-5.h-5 {:src "img/pdf.png" :alt "pdf icon"}]
        [:span.capitalize
         {:class (when checked "bg-yellow-300")}
         part-type]]]
      [:div                                 ; drive url
       [:a.flex.gap-x-4.items-center
        [:img.w-5.h-5 {:src "img/google-drive.png" :alt "google drive icon"}]
        [:span.-ml-px "Open in Google Drive"]]]
      [:div                                 ; bobcat url
       [:a.flex.gap-x-4.items-center
        [:img.w-5.h-5 {:src "img/library.png" :alt "library icon"}]
        [:span.-ml-px "Open in BobCat"]]]]]))
