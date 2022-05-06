(ns client.pages.index
  "Index page."
  (:require
   [client.components.nav :as nav]
   [client.components.header :as header]
   [client.components.search :as search]
   [client.components.footer :as footer]))

;; Quotes can be later added to the state
(def quo-short
  "Time heals, and experience teaches that the secret of happiness is in service to others.")

(def quo-really-long
  "I feel I am privileged to express a hope. The hope is this: that we shall have peace throughout the world, that we shall abolish wars and settle all international differences at the conference table, that we shall abolish all atom and hydrogen bombs before they abolish us. The future of the modern world demands modern thinking. Therefore, let us use the full force of our intelligence instead of obsolete homicidal methods in settling our international differences.")

(defn index-page
  "Index page."
  []
  [:div#app-main.h-fit.w-screen.my-2
   [header/index-header]
   [search/search-frame]
   [footer/footer-frame "Home" quo-really-long]])
