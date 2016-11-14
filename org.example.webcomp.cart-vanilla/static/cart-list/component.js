(function() {
  let template = `
    <div class="cart-list">
      <h2>Cart Contents:</h2>
      <table class="items-table"></table>
    </div>
  `;
  
  class CartListWidget extends HTMLElement {
    createdCallback() {
      this.createShadowRoot().innerHTML = template;
      this.$table = this.shadowRoot.querySelector('.items-table');
      this.requestServer();
    };

    requestServer() {
      var that = this;
      var xhr = new XMLHttpRequest();

      xhr.open('GET', '/cart-list/servlet/');
      xhr.onload = function() {
        var cart = JSON.parse(xhr.responseText);
        var rows = '';
        for (var i = 0; i < cart.length; i++) {
          var row = '<tr><td>' + cart[i].sku + '</td><td>' + cart[i].price + '</td></tr>';
          rows += row;
        }
        that.$table.innerHTML = rows;
      };
      xhr.send();
    };
  }
  document.registerElement('cart-list', CartListWidget);
})();