var ns = function (nsString, register) {
  var namespace = function (namespaceString) {
    var names = namespaceString.split('.');
    var root = window;

    for (var i in names) {
      if (names.hasOwnProperty(i)) {
        root[names[i]] = root[names[i]] || {};
        root = root[names[i]];
      }
    }

    return root;
  };
  register(namespace(nsString));
};