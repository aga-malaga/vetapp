import '../styles/navbar.css';
import React from "react";
import { useState } from "react";

    export default function Navbar() {
        const [isNavExpanded, setIsNavExpanded] = useState(false)
        return (
            <nav className="navigation">
                <a href="/" className="brand-name">
                    Menu
                </a>
                <button className="hamburger"
                        onClick={() => {
                            setIsNavExpanded(!isNavExpanded);
                        }}>
                    <img
                        className="h-5 w-5"
                        viewBox="0 0 20 20"
                        alt="menu" src="/icons8-menu-24.png" />
                </button>
                <div
                    className={
                        isNavExpanded ? "navigation-menu expanded" : "navigation-menu"
                    }>
                    <ul>
                        <li>
                            <a href="/home">Home</a>
                        </li>
                        <li>
                            <a href="/about">About</a>
                        </li>
                        <li>
                            <a href="/contact">Contact</a>
                        </li>
                    </ul>
                </div>
            </nav>
        );
}
