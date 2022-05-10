(ns client.pages.about
  "About page for the site."
  (:require
   [client.components.header :as header]))

(def ^:private background
  "Since the outbreak of COVID-19, NYU Shanghai library has seen an increasing demand for scan of book chapters or  pages.")

(def ^:private reasons
  "This is partly because many courses have moved online and partly because the shipping channels have been significantly disrupted. In such cases, scanning a small part of a book for courses has proven to be a faster and more flexible solution.")

(def ^:private problem
  "However, as the number of the scanned files grows over time, it also becomes harder for the library staff to track:")

(def ^:private challenges
  [
   "Which chapter (or part) from which book has been scanned?",
   "Where is a specific scan stored in Google Drive?"
   ])

(def ^:private aim
  "This project aims to solve the above problem.")

(def ^:private thanks-jade
  "I would like to express my appreciation to Jade, the student worker at NYU Shanghai Library, for her invaluable contribution to the database of this application. This project would have been impossible without her effort and dedication.")

(def ^:private thanks-tianshu
  "I would also like to thank Tianshu. His advice on the selection of tech stack for this project has been a great souce of help and inspiration.")

(def lorem
  "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.")

(def ^:private quo-long
  "I feel I am privileged to express a hope. The hope is this: that we shall have peace throughout the world, that we shall abolish wars and settle all international differences at the conference table, that we shall abolish all atom and hydrogen bombs before they abolish us. The future of the modern world demands modern thinking. Therefore, let us use the full force of our intelligence instead of obsolete homicidal methods in settling our international differences.")


(defn about-para
  "Paragraphs on the about page."
  [txt]
  [:p.w-full.mx-auto.my-2.px-1
    txt])

(defn about-page
  "The frame holding content for the about page."
  []
  [:div#app-about.w-full
   [:div.w-meet.lg:w-near.flex.flex-col.justify-center.py-2.px-2.mx-auto.mb-6
    [header/about-header "Motivation"]
    [about-para background]
    [about-para reasons]
    [about-para problem]
    [:ul.list-disc.w-near.pl-4.mx-auto.my-1
     (for [cha challenges]
       ^{:key cha}
       [:li.normal cha])]
    [about-para aim]]
   [:div.w-meet.flex.flex-col.justify-center.py-2.px-2.mx-auto.mb-6
    [header/about-header "Thanks"]
    [about-para thanks-jade]
    [about-para thanks-tianshu]]])
