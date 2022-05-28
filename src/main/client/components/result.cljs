(ns client.components.result
  "The area displying a single result."
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
                  (dispatch [:result/enabled-filter])
                  )
     :checked @(subscribe [:result/checked? part-type])}]
   [:label.capitalize {:for part-type} (cstr/replace (str part-type) #":" "")]]
  )

(defn result-item
  "Result item component, based on :chapter, :section, and so on."
  [part-type]
  [:div.w-near.h-fit.my-2.mx-2.flex.items-center.gap-x-2.border-1.rounded.hover:border-sky-500
   {:class (if @(subscribe [:result/filter-on?])
             (if @(subscribe [:result/checked? part-type])
               ""                    ; checked
               "hidden")             ; unchecked
             "")}                    ; filter disabled, all displayed
   ;; cover
   [:div.shrink-0.grow-0.flex
    [:img.w-44.h-auto.rounded-l.border-0
     {:src "img/covers/31124068856146_Database System Concepts.jpg",
      :alt "Book Cover Image"}]
    ]
   ;; Citation
   [:div.flex-auto.shrink-1.mx-1.p-1.flex.flex-col.gap-y-2
    [:p                                 ; title
     [:span.flex.gap-x-4.items-start
      [:img.w-5.h-5 {:src "img/book.png" :alt "book icon"}]
      ;; [:i.fi-book.text-lg]
      [:span.leading-5                  ; consider detect title length
       "Database Systems Concepts"]]]   ; if > 8 wds, then add leading-5
    [:p                                 ; ISBN
     [:span.flex.gap-x-4.items-center
      [:img.w-5.h-5 {:src "img/isbn.png" :alt "isbn icon"}]
      ;; [:i.fi-align-justify.text-lg.rotate-90]
      [:span "9781234560001"]]]
    [:p                                 ; barcode
     [:span.flex.gap-x-4.items-center
      [:img.w-5.h-5 {:src "img/barcode.png" :alt "barcode icon"}]
      ;; [:i.fi-price-tag.text-lg]
      [:span "31124056788904"]]]
    [:p                                 ; part type
     [:span.flex.gap-x-4.items-center
      [:img.w-5.h-5 {:src "img/pdf.png" :alt "pdf icon"}]
      ;; [:i.fi-page.text-lg]
      [:span.capitalize
       {:class (if @(subscribe [:result/checked? part-type])
                 "bg-yellow-300")}
       part-type]]]
    [:p                                 ; drive url
     [:a.flex.gap-x-4.items-center
      [:img.w-5.h-5 {:src "img/google-drive.png" :alt "google drive icon"}]
      ;; [:i.fi-social-drive.text-lg]
      [:span.-ml-px "Open in Google Drive"]]]
    [:p                                 ; bobcat url
     [:a.flex.gap-x-4.items-center
      [:img.w-5.h-5 {:src "img/library.png" :alt "library icon"}]
      ;; [:i.fi-link.text-lg]
      [:span.-ml-px "Open in BobCat"]]]
    ]
   ])
