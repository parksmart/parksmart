package com.parksmart

class FormTagLib {

    static defaultEncodeAs = "raw"

    static namespace = "form"

    def textField = { attrs, body ->
        out << render(template: '/templates/textField', model: [name: attrs.name, value: attrs.value, label: attrs.label, onfocus: attrs.onfocus ?: ''])
    }

    def numberField = { attrs, body ->
        out << render(template: '/templates/numberField', model: [name: attrs.name, value: attrs.value, label: attrs.label])
    }
}
