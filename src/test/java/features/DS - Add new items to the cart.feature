Feature: DS - Add new items to the cart

  @runthis
  Scenario: Add new items to the cart
    Given that the user has the demo store page loaded
    When the user searches for 'batman'
    Then the demo store shows the 'Resultados da pesqusisa' page loaded
    When the user clicks on 'Batman: Arkham City (X360)' item on the search results page
    Then the demo store shows the 'Batman: Arkham City (X360)' product page loaded
    When the user clicks on 'ADICIONAR AO CARRINHO'
    Then the demo store shows the 'O produto foi adicionado ao seu carrinho' modal
    And the user clicks on 'CONTINUAR COMPRAS'
    When the user searches for 'ps3'
    Then the demo store shows the 'Resultados da pesqusisa' page loaded
    When the user clicks on 'F.E.A.R. 3 (PS3) MX' item on the search results page
    Then the demo store shows the 'F.E.A.R. 3 (PS3) MX' product page loaded
    When the user clicks on 'ADICIONAR AO CARRINHO'
    Then the demo store shows the 'O produto foi adicionado ao seu carrinho' modal
    And the user clicks on 'CONTINUAR COMPRAS'
    When the user clicks on 'MY CART'
    And the user clicks on 'VER CARRINHO'
    Then the demo store shows the 'Conteudo do Carrinho' page loaded
    And the demo store shows the following items added to the cart:
      | Item                       |
      | Batman: Arkham City (X360) |
      | F.E.A.R. 3 (PS3) MX        |
