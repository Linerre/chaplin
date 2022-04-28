(ns client.pages.about
  "About page for the site."
  (:require
   [reagent.core :as r]
   [reagent.dom :as rdom]
   [client.components.nav :as nav]
   [client.components.header :as header]
   [client.components.footer :as footer]))

(def background
  "Since the outbreak of COVID-19, NYU Shanghai library has seen an increasing demand for the scan of book chapters or  pages.")

(def reasons
  "This is partly because many courses have moved online, and partly because the shipping channels have been significantly disrupted. In such cases, scanning a small part of a book for courses has proven to be a faster and more flexible solution.")

(def problem
  "However, as the number of the scanned files grows over time, it also becomes harder for the library staff to track:")

(def difficulties
  [
   "Which chapter (or part) from which book has been scanned?",
   "Where is a specific scan stored in Google Drive?"
   ])

(def aim
  "This project aims to solve the above problem.")

(def lorem
  "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.")

(def quo-long
  "I feel I am privileged to express a hope. The hope is this: that we shall have peace throughout the world, that we shall abolish wars and settle all international differences at the conference table, that we shall abolish all atom and hydrogen bombs before they abolish us. The future of the modern world demands modern thinking. Therefore, let us use the full force of our intelligence instead of obsolete homicidal methods in settling our international differences.")

(defn about-para
  "Paragraphs on the about page."
  [txt]
  [:p.w-near.pl-8.mx-auto.my-2
    txt])

(defn about-page
  "The frame holding content for the about page."
  []
  [:div#app-about.w-screen
   [:div.w-meet.flex.flex-col.justify-center.py-2.px-8.mx-auto
    [header/about-header "Motivation"]
    [about-para background]
    [about-para reasons]
    [about-para problem]
    [:ul.list-disc.w-near.pl-16.mx-auto.my-1
     (for [diff difficulties]
       ^{:key diff}
       [:li.normal diff])]
    [about-para aim]]
   [footer/footer-frame "About" quo-long]])
