import React from 'react'
import { Dropdown, Menu,Image } from 'semantic-ui-react'
import  Image1  from './1210800720211121091550148.jpg'



export default function SignedIn({signOut}) {
    return (
        <div>
            <Menu.Item>
                 <Image  avatar spaced="right" src={Image1}/>
                <Dropdown pointing="top left" text="Mustafa">
                    <Dropdown.Menu>
                        <Dropdown.Item text="Bilgilerim" icon="info"/>
                        <Dropdown.Item onClick={signOut} text="Çıkış Yap" icon="sign-out"/>
                    </Dropdown.Menu>
                </Dropdown>
            </Menu.Item>
        </div>
    )
}
