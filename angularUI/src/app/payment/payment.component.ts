import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {

  alert: boolean=false
  constructor(
    private _router: Router, private auth: AuthService) { }

  ngOnInit(): void {
  }

  options = {
    "key": "rzp_test_7HdkaZ1xFGPomB", 
    "amount": "50000",
    "currency": "INR",
    "name": "Acme Corp",
    "description": "Test Transaction",
    "image": "https://www.kindpng.com/picc/m/170-1702198_cash-on-delivery-rupees-clipart-transparent-png-rupees.png",
    "order_id": "", //This is a sample Order ID. Pass the `id` obtained in the response of Step 1
    "callback_url": "localhost:4200/home",
    "prefill": {
        "name": "Gaurav Kumar Singh",
        "email": "gaurav.kumar@example.com",
        "contact": "9999999999"
    },
    "notes": {
        "address": "Razorpay Corporate Office"
    },
    "theme": {
        "color": "#3399cc"
    }
};
rzp1;
pay(){
  this.rzp1 = new this.auth.nativeWindow.Razorpay(this.options);
  this.rzp1.open();
  this.showAlert()
}

  paymentUser()
  {
    this.alert = true
    this._router.navigate(['/home'])
  }

  closeAlert(){
    this.alert = false
  }

  public isVisible: boolean = false;

  showAlert() : void {
    if (this.isVisible) { // if the alert is visible return
      return;
    } 
    this.isVisible = true;
    setTimeout(()=> {this.isVisible = false; 
      this._router.navigate(['/home'])},2500); // hide the alert after 2.5s
    
  }
}
