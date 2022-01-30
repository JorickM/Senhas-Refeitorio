<?php

namespace App\Http\Controllers;

use App\Models\Purchase;
use App\Models\Meal;
use Illuminate\Http\Request;

class PurchaseController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        $purchase = Purchase::get()->toJson(JSON_PRETTY_PRINT);
        return response($purchase, 200);
    }

    public function byUser($codUser) {
        $purchases = Purchase::where('codUser', $codUser)->get();
        foreach($purchases as $purchase) {
          $purchase->meal = Meal::where('codMeal', $purchase->codMeal)->first();
        }
        return response($purchases->toJson(JSON_PRETTY_PRINT), 200);
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create(Request $request)
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
        //
    }

    /**
     * Display the specified resource.
     *
     * @param  \App\Models\Purchase  $purchase
     * @return \Illuminate\Http\Response
     */
    public function show($codPurchase)
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
        //
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \App\Models\Purchase  $purchase
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request)
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
    public function destroy($codPurchase)
    {
        if(Purchase::where('codPurchase', $codPurchase)->exists()) {
            $purchase = Purchase::where('codPurchase', $codPurchase);
            $purchase->delete();
    
            return response()->json([
              "message" => "records deleted"
            ], 202);
          } else {
            return response()->json([
              "message" => "Purchase not found"
            ], 404);
          }
        }
}
