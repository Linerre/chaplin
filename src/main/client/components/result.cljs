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
                  (dispatch [:result/enabled-filter]))
     :checked @(subscribe [:result/checked? part-type])}]
   [:label.capitalize {:for part-type} (cstr/replace (str part-type) #":" "")]]
  )

(defn result-item
  "Result item component, based on part-type"
  [part-type]
  [:div.w-near.h-fit.my-2.mx-2.p-1.flex.items-center.gap-x-2.border-2.border-sky-500
   {:class (fn [] (if-let [display? @(subscribe [:search/checked?])]
                    ""
                    "hidden"))}
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
      [:span "ISBN"]]]
    [:p                                 ; barcode
     [:span.flex.gap-x-4.items-center
      [:i.fi-price-tag.text-lg]
      [:span "Barcdoe"]]]
    [:p                                 ; part type
     [:span.flex.gap-x-4.items-center
      [:i.fi-page-export-pdf.text-lg]
      [:span part-type]]]
    [:p                                 ; drive url
     [:a.flex.gap-x-4.items-center
      [:i.fi-social-drive.text-lg]
      ;; [:img.w-4.h-4
      ;;  {:src "/img/google-drive.png"
      ;;   :alt "Google Drive Icon"}]
      [:span "Open in Google Drive"]]]
    [:p                                 ; bobcat url
     [:a.flex.gap-x-4.items-center
      [:i.fi-link.text-lg]
      [:span "Open in BobCat"]]]
    ]
   ])
