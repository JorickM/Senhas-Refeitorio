<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Purchase extends Model
{
    use HasFactory;

    protected $primaryKey = 'codPurchase';
    
    protected $table = 'purchases';

    protected $fillable = ['codMeal', 'codUser', 'flgUsed'];
}
