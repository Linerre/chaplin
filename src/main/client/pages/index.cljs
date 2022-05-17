(ns client.pages.index
  "Index page."
  (:require
   [client.components.header :refer [index-header]]
   [client.components.search :as search]
   ))

;; A page should be independent of any other pages
;; A page should return a view fn for router to use
(defn index-page
  "Index page."
  [& args]
  [:div#app-main.h-full.w-full
   [index-header]
   [search/search-frame]])
