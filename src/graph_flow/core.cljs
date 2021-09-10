(ns graph-flow.core
  (:require [clojure.string :as string]
            [helix.core :as helix]
            [helix.hooks :as hooks]
            [helix.dom :as d]
            [react-dom :as rdom]            
            ["react-flow-renderer" :default ReactFlow]))

;;import ReactFlow from 'react-flow-renderer';

;;https://shadow-cljs.github.io/docs/UsersGuide.html#_using_npm_packages

(def elements [{"id" "1", "data" {"label" "QueryTemp"}, "position" {"x" 250, "y" 5}}
               {"id" "2", "data" {"label" #_(d/div)
                                  "QuerySource2"}, "position" {"x" 100, "y" 100}}

               {"id" "3", "data" {"label" #_(d/div)
                                  "QuerySource3"}, "position" {"x" 400, "y" 100}}
               {"id" "e1-2", "source" "1", "target" "2", "animated" true}

               {"id" "e1-2", "source" "1", "target" "3", "animated" true}])

(helix/defnc app []
  (println "ReactFlow=" ReactFlow)
  (helix/$ ReactFlow {:name "aa"
                      :elements (clj->js  elements)}))



(defn init []
  (.log js/console "Mic test")
  (rdom/render
   (helix/$ app)
   (js/document.getElementById "root")))

#_(helix/$ ReactFlow {:elements elements})
#_(comment 


  (js->clj (.parse js/JSON "[{\"id\":\"1\",\"data\":{\"label\":\"Node 1\"},\"position\":{\"x\":250,\"y\":5}},{\"id\":\"2\",\"data\":{\"label\":\"Node 2\"},\"position\":{\"x\":100,\"y\":100}},{\"id\":\"e1-2\",\"source\":\"1\",\"target\":\"2\",\"animated\":true}]")))

