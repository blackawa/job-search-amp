(ns job-search-amp.handler.top
  (:require [ataraxy.core :as ataraxy]
            [ataraxy.response :as response] 
            [clojure.java.io :as io]
            [integrant.core :as ig]
            [hiccup.core :as hiccup]))

(defn- top []
  (hiccup/html [:span {:class "foo"} "bar"]))

(defmethod ig/init-key :job-search-amp.handler/top [_ options]
  (fn [{[_] :ataraxy/result}]
    [::response/ok (top)]))
