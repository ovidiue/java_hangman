// select control

var select = function (params) {
    var self = this;
    this.id = "select-" + new Date().getTime();
    this.html = "<select id=" + this.id + "><option>Please select option</option></select>";
    this.jQuery = "#" + this.id;

    this.params = {
        target: $('body'),
        source: []
    }
    
    this.test = function() {
        
    }

    if (params)
        $.extend(true, this.params, params);

    this.getSelected = function () {
        var option = $(self.jQuery).find("option:selected");
        return {
            id: option.prop('id'),
            value: option.text().trim()
        };
    }

    this.setValues = function (values) {
        self.params.source = values;
        self.removeValues();
        values.forEach(function (v) {
            var option = $("<option id=" + v.value + ">" + v.text + "</option>");
            $(self.jQuery).append(option);
        });
    }

    this.removeValues = function () {
        $(self.jQuery).find('option').filter(function () {
            return $(this).text().trim().toUpperCase() !== "PLEASE SELECT OPTION";
        }).remove();
    }

    this.init = function () {
        self.params.target.append($(self.html));
        self.setValues(params.source);
        self.defaultCSS();
    }

    this.defaultCSS = function () {
        $(self.jQuery).css({
            padding: '5px',
            'border-radius': '5px'
        });

        /*$(self.jQuery).find('option').mouseenter(function() {
         $(this).css({
         background: 'lightgray',
         color: 'blue'
         })
         }).mouseleave(function() {
         $(this).css({
         background: 'white',
         color: 'black'
         })
         });*/
    }

    this.destroy = function () {
        document.getElementById(self.id).remove();
        self = null;
    }
}


// example of params that can be used to initialise control
var params = {
    source: [{
            text: "Pizza",
            value: "Pizza"
        }, {
            text: "Lasagna",
            value: "Lasagna"
        }, {
            text: "Soup",
            value: "Soup"
        }, {
            text: "French fries",
            value: "French fries"
        }, {
            text: "Pasta",
            value: "Pasta"
        }],
    target: $('body')
};