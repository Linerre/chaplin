(ns client.pages.index
  (:require
   [reagent.core :as rc]))

;; in {:attr "val"}, "val" can be :val
;; but :val will be converted to "val" for DOM anyway
(defn search-box
  "Search box fregment"
  []
  (let [fields (rc/atom {})]
    [:form.my-4.py-4
     {:action "http://localhost:9322/result", :method "POST",
      :class "w-full flex flex-row gap-x-4 justify-center my-"}
     [:select#part-type.p-2.border-2.border-gray-900.bg-purple-950.text-white
      {:id "ptype",
       :name "ptype"
       :on-change #(swap! fields
                          assoc :name (-> % .-target .-value))}
      [:option {:name "chapter", :value "chapter"} "Chapter"]
      [:option {:name "section", :value "section"} "Section"]
      [:option {:name "part",    :value "part"} "Part"]
      [:option {:name "lesson",  :value "lesson"} "Lesson"]
      [:option {:name "pages",   :value "pages"} "Pages"]]
     [:label {:for "uquery"}]
     [:input.w-half.border-solid.border-2.border-gray-600.p-2
      {:type "text",
       :id "uquery",
       :name "uquery",
       :placeholder " Title, Author, ISBN, barcode ... "
       :on-change #(swap! fields
                          assoc :name (-> % .-target .-value))}]
     [:button#btn.bg-yellow-450.text-black.font-bold.p-2.hover:brightness-110
      {:type "submit",
       :on-click #(),
       :value "Search"}
      "Search"]]))
