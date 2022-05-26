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
  [:div.w-near.h-fit.my-2.mx-2.p-1.flex.items-center.gap-x-2.border-2.border-sky-500
   {:class (if @(subscribe [:result/filter-on?])
             (if @(subscribe [:result/checked? part-type])
               ""                    ; checked
               "hidden")             ; unchecked
             "")}                    ; filter disabled, all displayed
   ;; cover
   [:div.shrink-0.grow-0.flex
    [:img.w-36.h-48
     {:src "img/covers/31124068856146_Database System Concepts.jpg",
      :alt "Book Cover Image"}]
    ]
   ;; Citation
   [:div.flex-auto.shrink-1.mx-1.p-1
    [:p                                 ; title
     [:span.flex.gap-x-4.items-start
      [:i.fi-book.text-lg]
      [:span "400 million customers : the experiences--some happy, some sad of an American in China and what they taught him"]]]
    [:p                                 ; ISBN
     [:span.flex.gap-x-4.items-center
      [:i.fi-align-justify.text-lg.rotate-90]
      [:span "9781234560001"]]]
    [:p                                 ; barcode
     [:span.flex.gap-x-4.items-center
      [:i.fi-price-tag.text-lg]
      [:span "31124056788904"]]]
    [:p                                 ; part type
     [:span.flex.gap-x-4.items-center
      [:i.fi-page.text-lg]
      [:span.capitalize
       {:class (if @(subscribe [:result/checked? part-type])
                 "bg-yellow-300")}
       part-type]]]
    [:p                                 ; drive url
     [:a.flex.gap-x-4.items-center
      [:i.fi-social-drive.text-lg]
      [:span.-ml-px "Open in Google Drive"]]]
    [:p                                 ; bobcat url
     [:a.flex.gap-x-4.items-center
      [:i.fi-link.text-lg]
      [:span.-ml-px "Open in BobCat"]]]
    ]
   ])
