(ns chaplin.client.router
  "Client-side router"
  (:require
   [chaplin.client.pages.index :refer [search-box]]
   [reitit.frontend :as rf]))

(def fd-routes  ;; frontend routes
  [["/" {:name ::index, ;; ::index => :curr-ns/index == chaplin.router/index
         :view search-box}]])
