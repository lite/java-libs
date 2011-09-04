ns('FSS.sample.dialog', function(ns) {

    ns.getFields = function(fields, dialog) {
        var data = {};
        $.each(fields, function(index, elem) {
            data[elem] = dialog.find("#" + elem).val();
        });
        return data;
    };

    ns.initialize = function(options) {
        invoker = options['invoker'];
        title = options['title'];
        fields = options['fields'];
        url = options['url'];
        send = options['send'];

        dialog = $('<div title=\"' + title + '\"></div>');
        $(invoker).click(function() {
            $.ajax({url: url, global: false, success: ns.onShow});
        });
    };


    ns.onShow = function(data) {
        dialog.html(data)
                .dialog({
                    hide: "explode",
                    modal: true,
                    width: 450
                });

        $(".spinner").hide();
        $(send).click(ns.onSend);
    };

    ns.onSend = function() {
        $(".spinner").show();
        $.ajax({url: url, global: false, type: "POST",
                    data: (ns.getFields(fields, $(".share-dialog"))),
                    success: function(data) {
                        ns.onShow(data);
                    }});
        return false;
    };
});

ns('FSS.sample.share', function(ns) {
    ns.initialize = function() {
        FSS.sample.dialog.initialize({
                    invoker: '.share-link',
                    title: 'Share',
                    fields: ['imageUrl', 'senderName', 'replyTo', "to", "subject", 'message'],
                    url: $(".share-link").attr("ajaxUrl"),
                    send: '.send-share'
                });
    }
});

$(function() {
    FSS.sample.share.initialize();
});