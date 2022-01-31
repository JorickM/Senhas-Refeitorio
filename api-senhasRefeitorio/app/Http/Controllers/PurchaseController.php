<?php

namespace App\Http\Controllers;

use App\Models\Purchase;
use Illuminate\Http\Request;

class PurchaseController extends Controller
{

    public function index()
    {
      $purchases = Purchase::all();
      return view('purchases.list', compact('purchases','purchases'));
    }

    public function showAll()
    {
        $purchase = Purchase::get()->toJson(JSON_PRETTY_PRINT);
        return response($purchase, 200);
    }

    public function show(Purchase $purchase)
    {
        return view('purchases.view',compact('purchase'));
    }
    public function create()
    {
      return view('purchases.create');
    }

    public function addNew(Request $request)
    {
        $purchase = new Purchase;
        $purchase->codMeal = $request->codMeal;
        $purchase->codUser = $request->codUser;
        $purchase->flgUsed = $request->flgUsed;
        $purchase->save();
    
        return response()->json([
            "message" => "Purchase record created"
        ], 201);
    }
    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
      $request->validate([
          'txtCodMeal'=>'required',
          'txtCodUser' => 'required',
          'flgUsed' => 'required'
      ]);

      $purchase = new Purchase([
          'codMeal' => $request->get('txtCodMeal'),
          'codUser'=> $request->get('txtCodUser'),
          'flgUsed'=> $request->get('flgUsed')
      ]);

      $purchase->save();
      return redirect('/purchases')->with('success', 'purchase has been added');
  }
    /**
     * Display the specified resource.
     *
     * @param  \App\Models\Purchase  $purchase
     * @return \Illuminate\Http\Response
     */
    public function showDeatils($codPurchase)
    {
        if (Purchase::where('codPurchase', $codPurchase)->exists()) {
            $codPurchase = Purchase::where('codPurchase', $codPurchase)->get()->toJson(JSON_PRETTY_PRINT);
            return response($codPurchase, 200);
          } else {
            return response()->json([
              "message" => "Purchase not found"
            ], 404);
          }
      }







    /**
     * Show the form for editing the specified resource.
     *
     * @param  \App\Models\Purchase  $purchase
     * @return \Illuminate\Http\Response
     */
    public function edit(Purchase $purchase)
    {
      return view('purchases.edit',compact('purchase'));
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \App\Models\Purchase  $purchase
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request ,$codPurchase)
    {
          $request->validate([
            'txtCodMeal'=>'required',
            'txtCodUser' => 'required',
            'flgUsed' => 'required'
          ]);

        $purchase = Purchase::find($codPurchase);
        $purchase->codMeal = $request->get('txtCodMeal');
        $purchase->codUser = $request->get('txtCodUser');
        $purchase->flgUsed = $request->get('flgUsed');

        $purchase->update();

        return redirect('/purchases')->with('success', 'Purchase updated successfully');
    }


    public function updatePurchase(Request $request)
    {
        if (Purchase::where('codPurchase', $request->codPurchase)->exists()) {
            $purchase = Purchase::where('codPurchase', $request->codPurchase)->first();
            $purchase->codMeal = is_null($request->codMeal) ? $purchase->codMeal : $request->codMeal;
            $purchase->codUser = is_null($request->codUser) ? $purchase->codUser : $request->codUser;
            $purchase->flgUsed = is_null($request->flgUsed) ? $purchase->flgUsed : $request->flgUsed;
            $purchase->save();
            return response()->json([
                "message" => "records updated successfully"
            ], 200);
            } else {
            return response()->json([
                "message" => "Purchase not found"
            ], 404);
            
        }
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  \App\Models\Purchase  $purchase
     * @return \Illuminate\Http\Response
     */
    public function destroy(Purchase $purchase)
    {   
        $purchase->delete();
        return redirect('/purchases')->with('success', 'Purchase deleted successfully');
      }
}
