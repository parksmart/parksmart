package com.parksmart

class ApplicationTagLib {
    static defaultEncodeAs = [taglib:'raw']
    static namespace = "ps"

    def fieldValue = { attrs, body ->
        out << render(template: '/templates/fieldValue', model: ['fieldName': attrs?.fieldName, value: attrs?.value])
    }
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]
}
