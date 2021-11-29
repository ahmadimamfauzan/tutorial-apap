import listItems from '../../items.json';
import List from '../../components/List/index.js';
import React, { useState } from 'react';
import './index.css';

import Badge from '@material-ui/core/Badge';
import ShoppingCartIcon from '@mui/icons-material/ShoppingCart';
import { Fab } from '@material-ui/core';
import ViewStreamIcon from '@mui/icons-material/ViewStream';

function App() {
    const [shopItems, setShopItems] = useState(() => listItems);
    const [cartItems, setCartItems] = useState(() => []);
    const [cartHidden, setCartHidden] = useState(true);
    const [balance, setBalance] = useState(120);

    function updateShopItem(item, inCart) {
        const tempShopItems = [...shopItems];
        const targetInd = tempShopItems.findIndex((it) => it.id === item.id);
        tempShopItems[targetInd].inCart = inCart;
        setShopItems(tempShopItems);
    }

    function handleToggle() {
        setCartHidden(!cartHidden);
    }

    const kurangSaldo = (price) => {
        if(balance-price < 0) {
            alert("Balance is not sufficient");
            return false;
        }
        setBalance(balance-price);
        return true;
    }

    const tambahSaldo = (price) => {
        setBalance(balance+price);
    }

    function handleAddItemToCart(item) {
        const newItems = [...cartItems];
        const newItem = { ...item };
        const targetInd = newItems.findIndex((it) => it.id === newItem.id);
        
        
        if(targetInd < 0) {
            if(kurangSaldo(item.price) == true) {
                newItem.inCart = true;
                newItems.push(newItem);
                updateShopItem(newItem, true);
            }
        } 
        setCartItems(newItems);
    }

    function handleDeleteItemFromCart(item) {
        tambahSaldo(item.price);
        const existItems = [...this.state.cartItems];
        const newItem = { ...item };
        const targetInd = existItems.findIndex((it) => it.id === newItem.id);
        if(targetInd >= 0) {
            newItem.inChart = false;
            existItems.splice(targetInd, 1);
            this.updateShopItem(newItem, false);
        }
        this.setState({cartItems: existItems });
    }

   

    return (
        <div className="container-fluid">
            <h1 className="text-center mt-3 mb-0">Mini Commerce</h1>
            <div style={{ position: "fixed", top: 25, right: 25 }}>
                <Fab variant="extended" onClick={handleToggle}>
                    {cartHidden ?
                    <Badge color="secondary" badgeContent={cartItems.length}>
                        <ShoppingCartIcon />
                    </Badge>
                    : <ViewStreamIcon/>}
                </Fab>
            </div>
            <p className="text-center text-secondary text-sm font-italic">
                (this is a <strong>function-based</strong> application)
            </p>
            <p className="text-center text-primary">
                Your Balance: <b>{balance}</b>
            </p>

            <div className="container pt-3">
                <div className="row mt-3">
                    {!cartHidden ? (
                        <div className="col-sm">
                            <List
                                title="My Cart"
                                items={cartItems}
                                onItemClick={handleDeleteItemFromCart}
                            ></List>
                        </div>
                    ) : <div>
                            <List
                                title="List Items"
                                items={shopItems}
                                onItemClick={handleAddItemToCart}
                                isShopList={true}
                            ></List>
                        </div>}
                </div>
            </div>

        </div>

    );
}
export default App;
