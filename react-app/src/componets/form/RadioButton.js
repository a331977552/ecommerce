import React from "react";
import './RadioButton.css'

export  default function RadioButton(props) {


    return <label className="radio_button_container">{props.children}
        <input type="radio" checked={props.checked} value={props.value} onChange={props.onChange} name={props.name}/>
        <span className="radio_button_checkmark"/>
    </label>
}