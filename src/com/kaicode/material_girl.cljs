(ns com.kaicode.material_girl
  (:require [reagent.core :as r]
            [com.kaicode.mercury :as m]
            [cljsjs.material]))

(defn upgrade [this-component]
  (let [this-element (r/dom-node this-component)]
    (m/postpone #(js/componentHandler.upgradeElements this-element) 500)))

(defn component [render-func]
  (r/create-class {:component-did-update upgrade
                   :component-did-mount upgrade
                   :reagent-render render-func}))
