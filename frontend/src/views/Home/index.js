import React from 'react';
import listItems from '../../items.json';
import List from '../../components/List/index';
import './index.css';

import { Fab } from '@material-ui/core';
import Badge from '@material-ui/core/Badge';
import ShoppingCartIcon from '@mui/icons-material/ShoppingCart';
import ViewStreamIcon from '@mui/icons-material/ViewStream';
import DeleteIcon from '@mui/icons-material/Delete';
import { IconButton } from '@material-ui/core';

export default class Home extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            shopItems: listItems,
            cartItems: [],
            cartHidden: true,
            balance: 120,
        };
    }

    kurangSaldo = (price) => {
        if(this.state.balance-price < 0) {
            alert("Balance is not sufficient");
            return false;
        }
        this.state.balance -= price;
        return true;
    }

    tambahSaldo = (price) => {
        this.state.balance += price;
    }

    handleAddItemToCart = (item) => {
        const newItems = [...this.state.cartItems];
        const newItem = { ...item };
        const targetInd = newItems.findIndex((it) => it.id === newItem.id);
        if(targetInd < 0 & this.kurangSaldo(item.price)) {
            newItem.inCart = true;
            newItems.push(newItem);
            this.updateShopItem(newItem, true)
        }
        this.setState({ cartItems: newItems });
    };

    handleDeleteItemFromCart = (item) => {
        this.tambahSaldo(item.price);
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

    handleDeleteAllItem = () => {
        const existItems0 = [...this.state.cartItems];
        
        existItems0.forEach(this.handleDeleteItemFromCart);

        const existItems = [];
        const newItem = {};
        // this.updateShopItem(newItem, false);
        this.setState({cartItems: existItems});
    }

    updateShopItem = (item, inCart) => {
        const tempShopItems = this.state.shopItems;
        const targetInd = tempShopItems.findIndex((it) => it.id === item.id);
        tempShopItems[targetInd].inCart = inCart;
        this.setState({ shopItems: tempShopItems });
    }

    handleToggle = () => {
        const cartHidden = this.state.cartHidden;
        this.setState({ cartHidden: !cartHidden });
    };
    
    render() {
        return (
            <div className="container-fluid">
                <h1 className="text-center mt-3 mb-0">Mini Commerce</h1>
                <div style={{position: "fixed", top: 25, right:25 }}>
                    <Fab variant="extendend" onClick={this.handleToggle}>
                        {this.state.cartHidden ?
                        <Badge color="secondary" badgeContent={this.state.cartItems.length}>
                            <ShoppingCartIcon/>
                        </Badge> 
                        : <ViewStreamIcon/>}
                    </Fab>
                </div>

                <p className="text-center text-secondary text-sm font-italic">
                    (this is a <strong>class-based</strong> application)
                </p>
                <p className="text-center text-primeary">Your Balance: <b> {this.state.balance} </b></p>
                <div className="container pt-3">
                    <div className="row mt-3">
                        {!this.state.cartHidden ? (
                            <div className="col-sm">
                                <List
                                    title="My Cart"
                                    items={this.state.cartItems}
                                    onItemClick={this.handleDeleteItemFromCart}
                                ></List>
                                <IconButton onClick={this.handleDeleteAllItem}>
                                    <DeleteIcon />
                                </IconButton>
                            </div>
                        ) : <div className="col-sm">
                                <List
                                    title="List Items"
                                    items={this.state.shopItems}
                                    onItemClick={this.handleAddItemToCart}
                                    isShopList={true}
                                ></List>
                            </div> 
                        }
                    </div>
                </div>
            </div>
        );
    }
}